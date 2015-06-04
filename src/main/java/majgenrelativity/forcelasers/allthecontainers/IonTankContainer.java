package majgenrelativity.forcelasers.allthecontainers;

import majgenrelativity.forcelasers.tileEntities.ion_Creater_Tile_Entity;
import majgenrelativity.forcelasers.tileEntities.ion_Tank_Tile_Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class IonTankContainer extends Container {
protected ion_Tank_Tile_Entity tileEntity;
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return true;
	}
	public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

           
                icrafting.sendProgressBarUpdate(this, 1325, this.tileEntity.getIons());
           
        }

        
}
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int ions)
    {
        this.tileEntity.setIons(ions);
    }
    public IonTankContainer(ion_Tank_Tile_Entity tileEntity) {
    	this.tileEntity = tileEntity;
    }
}
