package data.format;

import exceptions.InvalidXMLInputFieldValue;


/**
 * Class required for storing Person instances
 */
public class Person {
    private String name;
    private String passportID;
    private Color eyeColor;
    private Location location;

    public void setEyeColor(String value) throws InvalidXMLInputFieldValue {
        if (Color.contains(value)) {
            this.eyeColor = Color.valueOf(value);
        } else {
            throw new InvalidXMLInputFieldValue("Недопустимое значение Person.EyeColor");
        }
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setName(String value) throws InvalidXMLInputFieldValue {
        if (!value.equals("")){
            name = value;
        } else{
            throw new InvalidXMLInputFieldValue("Недопустимое значение Person.NAME");
        }
    }

    public void setPassportID(String value) throws InvalidXMLInputFieldValue  {
        if ((value.length()>=5)||(value.equals(""))) {
            this.passportID = value;
        } else {
            throw new InvalidXMLInputFieldValue("Недопустимое значение Person.PassportID");
        }
    }

    public String getName() {
        return name;
    }

    public String getEyeColor() {
        return eyeColor.name();
    }

    public String getPassportID() {
        return passportID;
    }

    public String[] getLocation() {
        return new String[] {location.getX(),location.getY(),location.getZ()};
    }

    /**
     * Method used to check if all of nessessary fileds are given a value
     * @return true if all of fields are given a value and false if not
     */
    public boolean Complete() {
        if ((this.name == null) || (this.eyeColor == null)) {
            return false;
        } else if ((this.location!=null)&&(!this.location.Complete())){
            return false;
        } else{
            return true;
        }
    }
}