package majgenrelativity.forcelasers.tileEntities;

import majgenrelativity.forcelasers.MainFile;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;

public class ion_Tank_Tile_Entity extends TileEntity implements IUpdatePlayerListBox{
private int force_lasers_ions = 0;
	@Override
	public void update() {
		
	}
	public int getIons() {
		
		return force_lasers_ions;
	}
	public void setIons(int ions) {
		force_lasers_ions=ions;
	}
	@Override
    public void readFromNBT(NBTTagCompound tagCompound){
        super.readFromNBT(tagCompound);
        
        this.force_lasers_ions = tagCompound.getInteger("IonCount");
    }

	@Override
    public void writeToNBT(NBTTagCompound tagCompound){
        super.writeToNBT(tagCompound);

        
           tagCompound.setInteger("IonCount", force_lasers_ions);
    }
    public void pushIons(int ions) {
    	if (force_lasers_ions < 100) {
    	force_lasers_ions+=ions;
    	}
    }
}
