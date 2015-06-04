package majgenrelativity.forcelasers.tileEntities;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;

public class ion_Tank_Tile_Entity extends TileEntity implements IUpdatePlayerListBox{
private int force_lasers_ions = 0;
	@Override
	public void update() {
		// TODO Auto-generated method stub
		if (force_lasers_ions < 100) {
			force_lasers_ions+=0.5;
		}
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

        NBTTagList itemList = new NBTTagList();
        
        tagCompound.setTag("Inventory", itemList);
        
        tagCompound.setInteger("IonCount", force_lasers_ions);
    }
}
