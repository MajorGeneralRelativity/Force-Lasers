package majgenrelativity.forcelasers.alltheguis;

import majgenrelativity.forcelasers.MainFile;
import majgenrelativity.forcelasers.allthecontainers.IonCreaterContainer;
import majgenrelativity.forcelasers.allthecontainers.IonTankContainer;
import majgenrelativity.forcelasers.tileEntities.ion_Tank_Tile_Entity;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class IonTankGUI extends GuiContainer {
private ion_Tank_Tile_Entity tileEntity;
	
private ResourceLocation backgroundimage = new ResourceLocation("forcelasers:textures/gui/ion_creater_gui.png");
private int xSize = 176, ySize = 183;
		 
	public IonTankGUI(ion_Tank_Tile_Entity tileEntity) {
		super(new IonTankContainer(tileEntity));
		this.tileEntity = tileEntity;
		
	}

	//Draw the background
		@Override
	    public void drawGuiContainerBackgroundLayer(float renderPartialTicks, int mouseX, int mouseY){
	       this.mc.getTextureManager().bindTexture(backgroundimage);
	        int x = (this.width - xSize)/2;
	        int y = (this.height - ySize)/2;
	       drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	       drawTexturedModalRect(195, 55, 1, 1, getProgress(), 10);
	    }	
		public int getProgress() {
			
			return tileEntity.getIons();
		}

		//Draw the text
	    @Override
	    public void drawGuiContainerForegroundLayer(int x, int y){
	    	this.fontRendererObj.drawString(StatCollector.translateToLocal("container." + MainFile.MODID + ":ioncreater.name"), 8, -3, 4210752);
	    	this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, 78, 4210752);
	    	
	    }
	    
	    @Override
	    public boolean doesGuiPauseGame(){
	        return false;
	    }
	
}
