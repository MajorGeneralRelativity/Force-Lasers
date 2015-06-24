package majgenrelativity.forcelasers;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import majgenrelativity.forcelasers.alltheguis.GuiHandler;
import majgenrelativity.forcelasers.allthepackets.IonCreatorButtonPacket;
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
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
 
@Mod(modid = MainFile.MODID, version = MainFile.VERSION)

public class MainFile {

	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final String MODID = "forcelasers";
    public static final String VERSION = "0.4.1";
    public static SimpleNetworkWrapper IonCreatorButtonChannelVariable;
 
    @Mod.Instance(MODID)
    public static MainFile instance;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	IonCreatorButtonChannelVariable=NetworkRegistry.INSTANCE.newSimpleChannel("IonCreatorButtonChannel");
    	IonCreatorButtonChannelVariable.registerMessage(IonCreatorButtonPacket.Handler.class, IonCreatorButtonPacket.class, 0, Side.SERVER);
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
    public static Logger logger = LogManager.getLogger(MainFile.MODID);
}