import java.util.Scanner;
//=============================================================================
public class GasLaw {
    //-----------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
    //----The gas constant in Joules/mole/K
    private static final double GAS_CONSTANT = 8.3143;

    //-----------------------------------------------------------------------------
    public static void main(String[] args) {

//----Variables to hold system values
        double volume, moles, temperature;
        double pressure;

//----Get input for volume, moles, temperature
        System.out.print("Enter volume, moles, temperature : ");
        volume = keyboard.nextDouble();
        moles = keyboard.nextDouble();
        temperature = keyboard.nextDouble();

//----This is the equation to find the pressure
        pressure = moles * GAS_CONSTANT * temperature / volume;

//----This is the print statement to show the pressure
        System.out.println("Pressure is " + pressure);
    } // end of the main method
} //end of the class
//-----------------------------------------------------------------------------
//=============================================================================