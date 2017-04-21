package es.ulpgc.eite.clean.mvp.sample.modelview;

public class ModelItem {

    private String id;
    private String nombre;
    private String details;

    public ModelItem(String id, String nombre, String details) {
        this.id = id;
        this.nombre = nombre;
        this.details = details;
    }

    //////////////////////////////////// Id ///////////////////////////////////
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    ////////////////////////////////// Title ///////////////////////////////////
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    ////////////////////////////////// Detalles ////////////////////////////////////
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


    ///////////////////////////////// parametros tipicos ///////////////////////
    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ModelItem) {
            ModelItem item = (ModelItem) obj;
            if (item.getId() == getId()) {
                return true;
            }
        }
        return false;
    }
}
