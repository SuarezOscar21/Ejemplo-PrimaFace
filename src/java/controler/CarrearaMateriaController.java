package controler;

import modelo.CarrearaMateria;
import controler.util.JsfUtil;
import controler.util.JsfUtil.PersistAction;
import bean.CarrearaMateriaFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("carrearaMateriaController")
@SessionScoped
public class CarrearaMateriaController implements Serializable {

    @EJB
    private bean.CarrearaMateriaFacade ejbFacade;
    private List<CarrearaMateria> items = null;
    private CarrearaMateria selected;

    public CarrearaMateriaController() {
    }

    public CarrearaMateria getSelected() {
        return selected;
    }

    public void setSelected(CarrearaMateria selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getCarrearaMateriaPK().setCarreraIdcarrera(selected.getCarrera().getIdcarrera());
        selected.getCarrearaMateriaPK().setMateriaIdmateria(selected.getMateria().getIdmateria());
    }

    protected void initializeEmbeddableKey() {
        selected.setCarrearaMateriaPK(new modelo.CarrearaMateriaPK());
    }

    private CarrearaMateriaFacade getFacade() {
        return ejbFacade;
    }

    public CarrearaMateria prepareCreate() {
        selected = new CarrearaMateria();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CarrearaMateriaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CarrearaMateriaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CarrearaMateriaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CarrearaMateria> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public CarrearaMateria getCarrearaMateria(modelo.CarrearaMateriaPK id) {
        return getFacade().find(id);
    }

    public List<CarrearaMateria> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CarrearaMateria> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CarrearaMateria.class)
    public static class CarrearaMateriaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CarrearaMateriaController controller = (CarrearaMateriaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "carrearaMateriaController");
            return controller.getCarrearaMateria(getKey(value));
        }

        modelo.CarrearaMateriaPK getKey(String value) {
            modelo.CarrearaMateriaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new modelo.CarrearaMateriaPK();
            key.setId(Integer.parseInt(values[0]));
            key.setMateriaIdmateria(Integer.parseInt(values[1]));
            key.setCarreraIdcarrera(Integer.parseInt(values[2]));
            return key;
        }

        String getStringKey(modelo.CarrearaMateriaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getId());
            sb.append(SEPARATOR);
            sb.append(value.getMateriaIdmateria());
            sb.append(SEPARATOR);
            sb.append(value.getCarreraIdcarrera());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof CarrearaMateria) {
                CarrearaMateria o = (CarrearaMateria) object;
                return getStringKey(o.getCarrearaMateriaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CarrearaMateria.class.getName()});
                return null;
            }
        }

    }

}
