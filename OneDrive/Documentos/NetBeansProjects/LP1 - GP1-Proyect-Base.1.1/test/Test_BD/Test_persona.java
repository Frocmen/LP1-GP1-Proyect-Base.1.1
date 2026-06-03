/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test_BD;

import DaoImpl.PersonaDaoImpl;
import DaoImpl.UsuarioDaoImpl;
import Interface.IPersona;
import Interface.IUsuario;
import Model.Persona;
import Model.Rol;
import Model.Usuario;

public class Test_persona {

    IPersona dao = new PersonaDaoImpl();
    IUsuario Udao = new UsuarioDaoImpl();

    public static void main(String[] args) {
        Test_persona tp = new Test_persona();
        //tp.crea_persona();
        tp.validarUsuario();
    }

    public void crea_persona() {
        Persona p = new Persona();
        p.setNombre("Frocmen");
        p.setEmail("Frocmen.Villacorta@gmail.com");
        p.setDireccion("FONAVI");
        p.setTelefono("+51 928 593 599");

        Usuario u = new Usuario();
        u.setClave("61122679");
        u.setRol(Rol.ADMIN);
        int result = dao.insert(p, u);
        if (result > 0) {
            System.out.println("Usuario" + p.getEmail());
            System.out.println("Rol asignado" + u.getRol());
        } else {
            System.out.println("ERROR No se logró registrar");
        }
    }

    public void validarUsuario() {
        Usuario u = Udao.validate("Frocmen.Villacorta@gmail.com", "61122679");
        if (u != null && u.getPersona() != null) {
            System.out.println("BIENVENIDO: " + u.getPersona().getNombre());
            System.out.println("ROL: " + u.getRol());
        } else {
            System.out.println("CREDENCIALES INCORRECTAS");
        }
    }

}

