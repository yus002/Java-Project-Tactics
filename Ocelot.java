import java.awt.*;

public class Ocelot extends Leopard{
    // for not using magic numbers
    private static final String ocelotRepresentation = "Oce";
    private static final int confidenceCheck = 5;
    private static final String lionRepresentation = "Lion";
    private static final String felineRepresentation = "Fe";
    private static final String leopardRepresentation = "Lpd";

    private static final int increment = 3;

    public Ocelot(){
        this.displayName = ocelotRepresentation;

    }
    
    @Override
    /** Ocelots are LIGHT GRAY.
     *
     * @param none
     * @return the Colorful name of the ocelot
     */
        
    public Color getColor(){
        return Color.LIGHT_GRAY;
    }
    
    @Override
    
    /** The Ocelot will attack in the following ways:
     * If confidence is greater than 5, SCRATCH if the opponent is a Lion 
     * (both awake or asleep), a Feline, or a Leopard. POUNCE otherwise.
     * Otherwise, randomly choose an attack method.      
     * 
     * @param opponent The different species met
     * @return an attack method
     */

    public Attack getAttack(String opponent){
        if (confidence > confidenceCheck){
            if ((opponent == lionRepresentation) 
                || (opponent == felineRepresentation)
                    || (opponent == leopardRepresentation)){

                return Attack.SCRATCH;
            }
            else{
                return Attack.POUNCE;
            }
        }
        else{
           generateAttack();
        }
        return null;
       
    }

    @Override
   /** For every ocelot alive, increment the kills by 3. 
    * 
    * @param s the status of ocelots
    * @return nothing
    */

    public void buffBehavior(CritterState s){
        s.kills = s.kills + increment;
    }

    @Override
   /** change the count of kills back.
    * 
    * @param s the status of ocelots
    * @return nothing
    */

    public void debuff(CritterState s){
        s.kills = s.kills - increment;
    }

}
