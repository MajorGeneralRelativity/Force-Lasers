package majgenrelativity.forcelasers;

import majgenrelativity.forcelasers.alltheguis.GuiHandler;
import majgenrelativity.forcelasers.init.ForceLasersBlocks;
import majgenrelativity.forcelasers.init.ForceLasersItems;
import majgenrelativity.forcelasers.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
 
@Mod(modid = MainFile.MODID, version = MainFile.VERSION)

public class MainFile {

	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final String MODID = "forcelasers";
    public static final String VERSION = "0.1";
 
    @Mod.Instance(MODID)
    public static MainFile instance;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	ForceLasersItems.init();
    	ForceLasersItems.register();
    	proxy.registerTileEntities();
    	ForceLasersBlocks.init();
    	ForceLasersBlocks.register();
    	proxy.registerRenders();
    	
    	
	ModRecipes.addRecipes();
	GuiHandler.init();
	}
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	
    }
}