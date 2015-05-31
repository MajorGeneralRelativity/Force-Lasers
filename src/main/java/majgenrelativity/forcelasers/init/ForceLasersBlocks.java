package majgenrelativity.forcelasers.init;

import majgenrelativity.forcelasers.MainFile;
import majgenrelativity.forcelasers.blocks.ModBlock;
import majgenrelativity.forcelasers.blocks.ModBlockGUI;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ForceLasersBlocks {
	
	public static Block ion_creater;
	public static Block reinforced_obsidian;
	
	public static void init()
	{
		ion_creater = new ModBlockGUI().setUnlocalizedName("ion_creater");
		reinforced_obsidian = new ModBlock(Material.iron).setUnlocalizedName("reinforced_obsidian");
		reinforced_obsidian.setHarvestLevel("pickaxe", 3);
		reinforced_obsidian.setHardness(120F);
	}
	
	public static void register()
	{
		
		GameRegistry.registerBlock(reinforced_obsidian, reinforced_obsidian.getUnlocalizedName().substring(5));
		 GameRegistry.registerBlock(ion_creater, ion_creater.getUnlocalizedName().substring(5));
	}
	public static void registerRenders()
	{
		
		registerRender(ion_creater);
		registerRender(reinforced_obsidian);
	}
	public static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(MainFile.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
}
