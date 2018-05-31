/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileEntity;

/**
 *
 * @author Le Thanh Tung
 */
public class Entity {

    private String name;
    private String img;
    private String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Entity(String name, String img, String price) {
        this.name = name;
        this.img = img;
        this.price = price;
    }

    public Entity() {
    }

}
