package majgenrelativity.forcelasers.tileEntities;

import majgenrelativity.forcelasers.MainFile;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;

public class ion_Tank_Tile_Entity extends TileEntity implements IUpdatePlayerListBox{
private int force_lasers_ions = 0;
private boolean do_detections = true;
private ion_Creater_Tile_Entity cr1, cr2, cr3, cr4, cr5, cr6;
	@Override
	public void update() {
		if (do_detections == true) {
			if(worldObj.getTileEntity(getPos().down()) != null) {
                if(worldObj.getTileEntity(this.getPos().down()) instanceof ion_Creater_Tile_Entity) {
                         cr1=((ion_Creater_Tile_Entity)worldObj.getTileEntity(this.getPos().down()));
                        // MainFile.logger.info(worldObj.getTileEntity(this.getPos().down()).getBlockType().getUnlocalizedName());
                        }
                }
                if(worldObj.getTileEntity(getPos().east()) != null) {
                    if(worldObj.getTileEntity(this.getPos().east()) instanceof ion_Creater_Tile_Entity) {
                       cr2=((ion_Creater_Tile_Entity)worldObj.getTileEntity(this.getPos().east())); 
                }
                }
                if(worldObj.getTileEntity(getPos().west()) != null) {
                    if(worldObj.getTileEntity(this.getPos().west()) instanceof ion_Creater_Tile_Entity) {
                       cr3=((ion_Creater_Tile_Entity)worldObj.getTileEntity(this.getPos().west())); 
                }
                }
                if(worldObj.getTileEntity(getPos().south()) != null) {
                    if(worldObj.getTileEntity(this.getPos().south()) instanceof ion_Creater_Tile_Entity) {
                       cr4=((ion_Creater_Tile_Entity)worldObj.getTileEntity(this.getPos().south())); 
                }
                }
                if(worldObj.getTileEntity(getPos().north()) != null) {
                    if(worldObj.getTileEntity(this.getPos().north()) instanceof ion_Creater_Tile_Entity) {
                       cr5=((ion_Creater_Tile_Entity)worldObj.getTileEntity(this.getPos().north())); 
                }
                }
                if(worldObj.getTileEntity(getPos().up()) != null) {
                    if(worldObj.getTileEntity(this.getPos().up()) instanceof ion_Creater_Tile_Entity) {
                       cr6=((ion_Creater_Tile_Entity)worldObj.getTileEntity(this.getPos().up())); 
                }
                }
                do_detections=false;
		}
		// make ion creators redetect adjacent tanks
		if (cr1 != null) {
			cr1.redetect();
		}
		if (cr2 != null) {
			cr2.redetect();
		}
		if (cr3 != null) {
			cr3.redetect();
		}
		if (cr4 != null) {
			cr4.redetect();
		}
		if (cr5 != null) {
			cr5.redetect();
		}
		if (cr6 != null) {
			cr6.redetect();
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

        
           tagCompound.setInteger("IonCount", force_lasers_ions);
    }
    public void pushIons(int ions) {
    	if (force_lasers_ions < 100) {
    	force_lasers_ions+=ions;
    	}
    }
}
