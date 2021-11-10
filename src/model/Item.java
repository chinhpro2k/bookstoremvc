package model;

public class Item {
	private String _id;
	private float _price;
	private String _name;
	private Promotion _promo;
	private String _bookId;

	public Item() {
	}



	public Item(float _price, String _name) {
		super();
		this._price = _price;
		this._name = _name;
	}



	public Item(String _id, float _price, String _name, Promotion _promo, String _bookId) {
		this._id = _id;
		this._price = _price;
		this._name = _name;
		this._promo = _promo;
		this._bookId = _bookId;
	}

	public String getId() {
		return _id;
	}

	public void setId(String _id) {
		this._id = _id;
	}

	public float getPrice() {
		return _price;
	}

	public void setPrice(float _price) {
		this._price = _price;
	}

	public String getName() {
		return _name;
	}

	public void setName(String _name) {
		this._name = _name;
	}

	public Promotion getPromo() {
		return _promo;
	}

	public void setPromo(Promotion _promo) {
		this._promo = _promo;
	}

	public String get_bookId() {
		return _bookId;
	}

	public void set_bookId(String _bookId) {
		this._bookId = _bookId;
	}

}