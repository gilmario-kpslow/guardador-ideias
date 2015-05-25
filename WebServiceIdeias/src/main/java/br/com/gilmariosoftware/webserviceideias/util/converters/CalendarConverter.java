package br.com.gilmariosoftware.webserviceideias.util.converters;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

/**
 *
 * @author gilmario
 */
@Named
public class CalendarConverter implements Serializable, Converter {

    private final SimpleDateFormat formater;

    public CalendarConverter() {
        this.formater = new SimpleDateFormat("dd/MM/yyyy");
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(formater.parse(value));
            return calendar;
        } catch (ParseException ex) {
            Logger.getLogger(CalendarConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Calendar calendar = (Calendar) value;
        if (value != null) {
            return formater.format(calendar.getTime());
        }
        return "";
    }

}
