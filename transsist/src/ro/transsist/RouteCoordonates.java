package ro.transsist;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: motan
 * Date: 1/4/14
 * Time: 10:36 AM
 * To change this template use File | Settings | File Templates.
 */
//        LatLng galati = new LatLng(45.42558,  28.03054);

public interface RouteCoordonates {

    public static Route CimitirSfLazar = new Route("Cimitir Sf. Lazar", 45.427266, 28.012133);
    public static Route Micro17 = new Route("Micro 17", 45.426663, 28.013678);
    public static Route Oltului = new Route("Oltului", 45.427055, 28.017690);
    public static Route Tiglina1 = new Route("Tiglina 1", 45.427718, 28.028591);
    public static Route Banci = new Route("Banci", 45.428711, 28.039813);
    public static Route Mazepa = new Route("Mazepa", 45.430594, 28.046186);
    public static Route Potcoava = new Route("Potcoava", 45.432777, 28.050349);
    public static Route ParcEminescu = new Route("Parc Eminescu", 45.435540, 28.055584);
    public static Route Universitate = new Route("Universitate", 45.439222, 28.056571);
    public static Route ParfumulTeilor = new Route("Parfumul Teilor", 45.442790, 28.056571);
    public static Route Basarabiei = new Route("Basarabiei", 45.445703, 28.054866);
    public static Route BlocIalomita = new Route("Bloc Ialomita", 45.448623, 28.053031);
    public static Route CamineStudentesti = new Route("Camine Studentesti", 45.454765, 28.049287);
    public static Route CaminulDeBatrani = new Route("Caminul de Batrani", 45.458370, 28.047173);
    public static Route ParcCFR = new Route("Parc CFR", 45.462810, 28.044641);

    public static ArrayList<Route> routesOf104 = new ArrayList<Route>();;




}
