import Entidades.*;
import Repositorio.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

//  FALTA 5.a.b.c.d.e
public class Main {
    public static void main(String[] args) {

        InMemoryRepository<Empresa> EmpresaRepo = new InMemoryRepository<>();
        System.out.println(" -----------Creamos el repositorio----------");

        Pais arg = Pais.builder()
                .nombre("Argentina")
                .build();
        System.out.println(" -----------Creamos un pais----------");

        Provincia mza = Provincia.builder()
                .id(1L)
                .nombre("Mendoza")
                .pais(arg)
                .build();
        Provincia cba = Provincia.builder()
                .id(2L)
                .nombre("Cordoba")
                .pais(arg)
                .build();
        System.out.println(" -----------Creamos provincias----------");

        Localidad LH = Localidad.builder()
                .id(1L)
                .nombre("Las Heras")
                .provincia(mza)
                .build();
        Localidad CP = Localidad.builder()
                .id(2L)
                .nombre("Carlos Paz")
                .provincia(cba)
                .build();
        Localidad cap = Localidad.builder()
                .id(3L)
                .nombre("Capital")
                .provincia(cba)
                .build();
        Localidad gy = Localidad.builder()
                .id(4L)
                .nombre("Guaymallen")
                .provincia(mza)
                .build();
        System.out.println(" -----------Creamos localidades----------");

        Domicilio dom1 = Domicilio.builder()
                .id(1L)
                .calle("Antartida Argentina")
                .numero(1000)
                .cp(5539)
                .piso(1)
                .nroDpto(1)
                .localidad(LH)
                .build();
        Domicilio dom2 = Domicilio.builder()
                .id(2L)
                .calle("San Martin")
                .numero(600)
                .cp(8504)
                .piso(1)
                .nroDpto(1)
                .localidad(CP)
                .build();
        Domicilio dom3 = Domicilio.builder()
                .id(3L)
                .calle("Belgrano")
                .numero(200)
                .cp(8509)
                .piso(1)
                .nroDpto(1)
                .localidad(cap)
                .build();
        Domicilio dom4 = Domicilio.builder()
                .id(4L)
                .calle("Cabral")
                .numero(850)
                .cp(5509)
                .piso(1)
                .nroDpto(1)
                .localidad(gy)
                .build();
        System.out.println(" -----------Creamos domicilios----------");

        Sucursal suc1 = Sucursal.builder()
                .id(1L)
                .nombre("Sucursal 1 LH")
                .horarioApertura(LocalTime.of(8, 0))
                .horarioCierre(LocalTime.of(10, 0))
                .es_Casa_Matriz(true)
                .domicilio(dom1)
                .build();
        Sucursal suc2 = Sucursal.builder()
                .id(2L)
                .nombre("Sucursal 2 GY")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(10, 30))
                .es_Casa_Matriz(false)
                .domicilio(dom4)
                .build();
        Sucursal suc3 = Sucursal.builder()
                .id(3L)
                .nombre("Sucursal 3 CP")
                .horarioApertura(LocalTime.of(9, 30))
                .horarioCierre(LocalTime.of(15, 30))
                .es_Casa_Matriz(true)
                .domicilio(dom2)
                .build();
        Sucursal suc4 = Sucursal.builder()
                .id(4L)
                .nombre("Sucursal 4 CAP")
                .horarioApertura(LocalTime.of(6, 0))
                .horarioCierre(LocalTime.of(10, 0))
                .es_Casa_Matriz(false)
                .domicilio(dom3)
                .build();
        System.out.println(" -----------Creamos sucursales----------");

        Empresa empresa1 = Empresa.builder()
                .nombre("Empresa 1")
                .razonSocial("CARGAS SA")
                .cuit((int) 30709969583L)
                .sucursales(new HashSet<>(Set.of(suc1, suc2)))
                .build();
        Empresa empresa2 = Empresa.builder()
                .nombre("Empresa 2")
                .razonSocial("INCAT SRL")
                .cuit((int) 30525418835L)
                .sucursales(new HashSet<>(Set.of(suc3, suc4)))
                .build();
        System.out.println(" -----------Creamos empresas----------");

        suc1.setEmpresa(empresa1);
        suc2.setEmpresa(empresa1);
        suc3.setEmpresa(empresa2);
        suc4.setEmpresa(empresa2);
        System.out.println(" -----------Asignamos la empresa a las sucursales----------");

        EmpresaRepo.save(empresa1);
        EmpresaRepo.save(empresa2);
        System.out.println(" -----------Guardamos las empresas----------");

    }
}