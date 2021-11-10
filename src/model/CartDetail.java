package model;

import java.io.Serializable;

public class CartDetail implements Serializable {
	private String id;
	private Item item;
	private String cartID;
	private int Quantity;
	
	public CartDetail() {
		
	}
	
	public CartDetail(String id, Item item, String cartID, int quantity) {
		super();
		this.id = id;
		this.item = item;
		this.cartID = cartID;
		Quantity = quantity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getCartID() {
		return cartID;
	}

	public void setCartID(String cartID) {
		this.cartID = cartID;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	
	
	
}
