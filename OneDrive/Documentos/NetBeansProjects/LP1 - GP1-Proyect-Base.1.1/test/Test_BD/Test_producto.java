/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test_BD;

import DaoImpl.ProductoDaoImpl;
import Interface.IProducto;
import Model.Productos;
import java.util.List;
/**
 *
 * @author Frocmen
 */
public class Test_producto {

      public static IProducto dao = new ProductoDaoImpl();

    public static void main(String[] args) {
        Test_producto tP = new Test_producto();
        //tP.listar();
        //tP.insert();
        //tP.update();
        //tP.updateStock();
      // tP.SearchByID();
       tP.delete();
    }

    public static void listar() {
        List<Productos> Lista = dao.lista();

        if (Lista != null && !Lista.isEmpty()) {
            System.out.println("ID\tNombre\tPrecio\tStock");
            for (Productos ps : Lista) {
                System.out.println(ps.getId_producto()
                        + "\t" + ps.getNombre() + "\t$"
                        + ps.getPrecio() + "\t" + ps.getStock());

            }
        } else {
            System.out.println(" NO HAY PRODUCTOS ");
        }

    }
    public static void insert() {
        Productos p = new Productos();
        p.setNombre("Laptop Lenovo Legion 5 Pro");
        p.setDescripcion("Alto rendimiento + pantalla QHD 165Hz + SSD 1TB + 16GB RAM");
        p.setPrecio(1500);
        p.setStock(25);
        p.setImagen("/resources/img/papa.jpg");
        boolean result = dao.insert(p);

        if (result) {
            System.out.println(" PRODUCTO INSERTADO");
        } else {
            System.out.println(" |ERROR| No sé logró registrar");

        }
    }
     public static void update() {
        Productos p = new Productos();
        p.setNombre("Oppo Reno Pro 11");
        p.setDescripcion("CALIDAD RENDIMIENTO 256 GB + CALIDAD IMAGEN");
        p.setPrecio(1260.20);
        p.setStock(18);
        p.setImagen("/resources/img/papa.jpg");
        p.setId_producto(3);

        boolean result = dao.update(p);
        if (result) {
            System.out.println(" PRODUCTO ACTUALIZADO");
        } else {
            System.out.println(" |ERROR| No sé logró actualizar");

        }
    }
     
     public static void updateStock() {
        boolean result = dao.updateStock(3, 160);
        if (result) {
            System.out.println(" STOCK ACTUALIZADO");
        } else {
            System.out.println(" |ERROR| No sé logró actualizar");
        }
    }
      public static void SearchByID() {
        Productos pr = dao.SearchByID(3);

        if (pr != null) {
            System.out.println(" PRODUCTOS ENCONTRADO");
            System.out.println("ID:" + pr.getId_producto());
            System.out.println("Nombre:" + pr.getNombre());
            System.out.println("Descripcion:" + pr.getDescripcion());
            System.out.println("Precio:" + pr.getPrecio());
            System.out.println("Stock:" + pr.getStock());
            System.out.println("Ruta Img:" + pr.getImagen());
        } else {
            System.out.println("|ERROR| No hay registros");
        }

    }
      public static void delete() {
        boolean result = dao.delete(3);
        if (result) {
            System.out.println("ELIMINADO");
        } else {
            System.out.println(" |ERROR| No se logró eliminar");
        }
    }
}
