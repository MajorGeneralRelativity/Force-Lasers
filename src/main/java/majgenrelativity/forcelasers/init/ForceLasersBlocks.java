package majgenrelativity.forcelasers.init;

import majgenrelativity.forcelasers.MainFile;
import majgenrelativity.forcelasers.blocks.Force_Field_Emitter;
import majgenrelativity.forcelasers.blocks.ModBlock;
import majgenrelativity.forcelasers.blocks.ion_Creater_Block;
import majgenrelativity.forcelasers.blocks.ion_Storage_Tank;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ForceLasersBlocks {
	
	public static Block ion_creater;
	public static Block reinforced_obsidian;
	public static Block ion_storage_tank;
	public static Block force_lasers_field_emitter;
	
	public static void init()
	{
		ion_creater = new ion_Creater_Block().setUnlocalizedName("ion_creater");
		reinforced_obsidian = new ModBlock(Material.iron).setUnlocalizedName("reinforced_obsidian");
		reinforced_obsidian.setHarvestLevel("pickaxe", 3);
		reinforced_obsidian.setHardness(120F);
		ion_storage_tank = new ion_Storage_Tank().setUnlocalizedName("ion_storage_tank");
		force_lasers_field_emitter = new Force_Field_Emitter().setUnlocalizedName("force_lasers_field_emitter");
	}
	
	public static void register()
	{
		GameRegistry.registerBlock(ion_storage_tank, ion_storage_tank.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(reinforced_obsidian, reinforced_obsidian.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ion_creater, ion_creater.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(force_lasers_field_emitter, force_lasers_field_emitter.getUnlocalizedName().substring(5));
	}
	public static void registerRenders()
	{
		registerRender(ion_storage_tank);
		registerRender(ion_creater);
		registerRender(reinforced_obsidian);
		registerRender(force_lasers_field_emitter);
	}
	public static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(MainFile.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
}
