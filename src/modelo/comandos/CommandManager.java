/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.comandos;

import java.util.HashMap;

/**
 *
 * @author josh
 */
public class CommandManager {   

    //Singleton
    private static CommandManager commandManager;       
    public static synchronized CommandManager getInstance() {
        if (commandManager == null) {               
            commandManager = new CommandManager();   
        }
        return commandManager; 
    }
    private CommandManager() {     
        //registrar los comandos
        registCommand(LoginCommand.COMMAN_NAME, LoginCommand.class);
        registCommand(LogoutCommand.COMMAN_NAME, LogoutCommand.class);
        
        registCommand(RetarCommand.COMMAN_NAME, RetarCommand.class);
        registCommand(SelecGuerreroCommand.COMMAN_NAME, SelecGuerreroCommand.class);
        registCommand(SelecArmaCommand.COMMAN_NAME, SelecArmaCommand.class);
        registCommand(VerArmasCommand.COMMAN_NAME, VerArmasCommand.class);
        registCommand(VerGuerrerosCommand.COMMAN_NAME, VerGuerrerosCommand.class);
        registCommand(ReiniciarEquipoCommand.COMMAN_NAME, ReiniciarEquipoCommand.class);
        registCommand(EquipoPruebaCommand.COMMAN_NAME, EquipoPruebaCommand.class);
        
        registCommand(AtacarCommand.COMMAN_NAME, AtacarCommand.class);
        registCommand(ChatCommand.COMMAN_NAME, ChatCommand.class);
        registCommand(ComodinCommand.COMMAN_NAME, ComodinCommand.class);
        registCommand(PasarTurnoCommand.COMMAN_NAME, PasarTurnoCommand.class);
        registCommand(RecargarCommand.COMMAN_NAME, RecargarCommand.class);
        registCommand(RendirseCommand.COMMAN_NAME, RendirseCommand.class);
        registCommand(SalidaMutuaCommand.COMMAN_NAME, SalidaMutuaCommand.class);
        registCommand(MostrarCommand.COMMAN_NAME, MostrarCommand.class);
        
        
        registCommand(ExitCommand.COMMAN_NAME, ExitCommand.class);
        
    } 
    
    //lista de comandos : COMMANDS
    private static final HashMap<String, Class<? extends ICommand>> COMMANDS =          
            new HashMap<String, Class<? extends ICommand>>();         
    
    public ICommand getCommand(String commandName) {           
        if (COMMANDS.containsKey(commandName.toUpperCase())) {               
            try {                   
                return COMMANDS.get(commandName.toUpperCase()).newInstance();
            } catch (Exception e) {   e.printStackTrace();                   
            return new ErrorCommand();   
            }           
        }
        else {
            return new NotFoundCommand();   
        }   
    }   
    
    public void registCommand(String commandName, Class<? extends ICommand> command) {   
        COMMANDS.put(commandName.toUpperCase(), command);   
    }   
}
