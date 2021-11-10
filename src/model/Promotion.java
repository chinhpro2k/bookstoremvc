package model;

import java.util.Date;

public class Promotion {
	private String _id;
	private String _name;
	private double _percent;
	private Date _expDate;

    public Promotion() {
    }

    public Promotion(String _id, String _name, double _percent, Date _expDate) {
        this._id = _id;
        this._name = _name;
        this._percent = _percent;
        this._expDate = _expDate;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public double getPercent() {
        return _percent;
    }

    public void setPercent(double _percent) {
        this._percent = _percent;
    }

    public Date getExpDate() {
        return _expDate;
    }

    public void setExpDate(Date _expDate) {
        this._expDate = _expDate;
    }
	
}