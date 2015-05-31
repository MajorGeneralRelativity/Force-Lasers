package majgenrelativity.forcelasers;

import majgenrelativity.forcelasers.init.ForceLasersItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
public static void addRecipes()
{
	// GameRegistry.addRecipe(new ItemStack(Blocks.obsidian),
    		// "AAA",
    		// "AAA",
    		// "AAA",
    		// 'A', Items.cookie
    	// );
    	//GameRegistry.addRecipe(new ItemStack(Items.apple, 4), 
    		//"AA",
    		//"AA",
    		//'A', Blocks.cobblestone
    	//);
    	//GameRegistry.addRecipe(new ItemStack(Items.dye, 2, 15),
    		//"AB ",
    		//"AAC",
    		//"A  ",
    		//'A', Items.cookie, 'B', Blocks.dirt, 'C', new ItemStack(Items.dye, 1, 1)
    	//);
    	
    	GameRegistry.addShapelessRecipe(new ItemStack(Blocks.bedrock), Items.diamond, Items.lava_bucket);
    	
    	GameRegistry.addSmelting(Blocks.obsidian, new ItemStack(Items.diamond, 2), 1F);
    	
    	//add recipe for focus matrix
    	GameRegistry.addRecipe(new ItemStack(ForceLasersItems.focus_matrix),
    	"A A",
    	" B ",
    	"A A",
    	'A', Items.iron_ingot, 'B', Items.diamond
    	);
    	GameRegistry.addRecipe(new ItemStack(ForceLasersItems.ionizer),
    			"ABA",
    			"BDB",
    			"CBC",
    			'A', Items.iron_ingot, 'B', Items.glowstone_dust, 'C', Items.redstone, 'D', ForceLasersItems.crystal_matrix
    			);
}
}
