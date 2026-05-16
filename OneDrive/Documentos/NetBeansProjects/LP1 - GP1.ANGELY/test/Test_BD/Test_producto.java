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
        tP.listar();
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
}
