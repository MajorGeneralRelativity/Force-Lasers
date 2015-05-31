package majgenrelativity.forcelasers.init;

import majgenrelativity.forcelasers.MainFile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ForceLasersItems {
	
	public static Item focus_matrix;
	public static Item crystal_matrix;
	public static Item ionizer;
	
	public static void init(){
		focus_matrix= new Item().setUnlocalizedName("focus_matrix");
		crystal_matrix = new Item().setUnlocalizedName("crystal_matrix");
		ionizer = new Item().setUnlocalizedName("ionizer");
	}
	
	public static void register()
	{
		GameRegistry.registerItem(focus_matrix, focus_matrix.getUnlocalizedName().substring(5)); //tile.focus_matrix, but substring doesn't read tile, just the rest
		GameRegistry.registerItem(crystal_matrix, crystal_matrix.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ionizer, ionizer.getUnlocalizedName().substring(5));
	}
	public static void registerRenders()
	{
		registerRender(focus_matrix);
		registerRender(crystal_matrix);
		registerRender(ionizer);
	}
	public static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(MainFile.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
	
