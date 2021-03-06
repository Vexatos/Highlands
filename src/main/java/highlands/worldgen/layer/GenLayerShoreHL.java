package highlands.worldgen.layer;

import highlands.HighlandsMain;
import highlands.api.HighlandsBiomes;
import highlands.biome.BiomeGenBaseHighlands;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerShoreHL extends GenLayer
{
	
	public static int[] shoredBiomeList;
	
	
	
	
    public GenLayerShoreHL(long par1, GenLayer par3GenLayer)
    {
        super(par1);
        this.parent = par3GenLayer;
        shoredBiomeList = new int[] {
        		HighlandsBiomes.ocean2.biomeID,
        		//watery biomes
        		BiomeGenBase.river.biomeID,
        		BiomeGenBase.swampland.biomeID,
        		HighlandsBiomes.estuary.biomeID,
        		HighlandsBiomes.lake.biomeID,
        		HighlandsBiomes.bog.biomeID,
        		HighlandsBiomes.lowlands.biomeID,
        		HighlandsBiomes.tropicalIslands.biomeID,
        		//cliffs/hills biomes
        		BiomeGenBase.extremeHills.biomeID,
        		HighlandsBiomes.cliffs.biomeID,
        		HighlandsBiomes.woodsMountains.biomeID,
        		HighlandsBiomes.flyingMountains.biomeID,
        		//islands
        		HighlandsBiomes.jungleIsland.biomeID,
        		HighlandsBiomes.forestIsland.biomeID,
        		HighlandsBiomes.desertIsland.biomeID,
        		HighlandsBiomes.snowIsland.biomeID,
        		HighlandsBiomes.volcanoIsland.biomeID,
        		HighlandsBiomes.rockIsland.biomeID,
        		HighlandsBiomes.windyIsland.biomeID,
        		//mountains
        		HighlandsBiomes.snowMountains.biomeID,
        		HighlandsBiomes.rockMountains.biomeID,
        		HighlandsBiomes.desertMountains.biomeID,
        };
    }

    /**
     * Returns a list of integer values generated by this layer. These may be interpreted as temperatures, rainfall
     * amounts, or biomeList[] indices based on the particular GenLayer subclass.
     */
    public int[] getInts(int par1, int par2, int par3, int par4)
    {
        int[] var5 = this.parent.getInts(par1 - 1, par2 - 1, par3 + 2, par4 + 2);
        int[] var6 = IntCache.getIntCache(par3 * par4);

        for (int var7 = 0; var7 < par4; ++var7)
        {
            for (int var8 = 0; var8 < par3; ++var8)
            {
                this.initChunkSeed((long)(var8 + par1), (long)(var7 + par2));
                int var9 = var5[var8 + 1 + (var7 + 1) * (par3 + 2)];//biome at current position
                int var10;
                int var11;
                int var12;
                int var13;

                var6[var8 + var7 * par3] = var9;
                
                boolean finished = false;
                
                if (var9 == BiomeGenBase.mushroomIsland.biomeID)
                {
                    var10 = var5[var8 + 1 + (var7 + 1 - 1) * (par3 + 2)];
                    var11 = var5[var8 + 1 + 1 + (var7 + 1) * (par3 + 2)];
                    var12 = var5[var8 + 1 - 1 + (var7 + 1) * (par3 + 2)];
                    var13 = var5[var8 + 1 + (var7 + 1 + 1) * (par3 + 2)];

                    if (!(var10 != HighlandsBiomes.ocean2.biomeID && var11 != HighlandsBiomes.ocean2.biomeID
                    		&& var12 != HighlandsBiomes.ocean2.biomeID && var13 != HighlandsBiomes.ocean2.biomeID))
                    {
                    	var6[var8 + var7 * par3] = BiomeGenBase.mushroomIslandShore.biomeID;
                    	finished = true;
                    }
                }
                //revised ocean-beach border - this is a list of biomes not to border with beaches
                if (var9 != HighlandsBiomes.ocean2.biomeID &&
                		//watery biomes
                		var9 != BiomeGenBase.river.biomeID &&
                		var9 != BiomeGenBase.swampland.biomeID &&
                		var9 != HighlandsBiomes.estuary.biomeID &&
                		var9 != HighlandsBiomes.lake.biomeID &&
                		var9 != HighlandsBiomes.bog.biomeID &&
                		var9 != HighlandsBiomes.lowlands.biomeID &&
                		//cliffs/hills biomes
                		var9 != BiomeGenBase.extremeHills.biomeID &&
                		var9 != HighlandsBiomes.cliffs.biomeID &&
                		var9 != HighlandsBiomes.woodsMountains.biomeID &&
                		var9 != HighlandsBiomes.flyingMountains.biomeID &&
                		var9 != HighlandsBiomes.snowMountains.biomeID &&
                		var9 != HighlandsBiomes.rockMountains.biomeID &&
                		var9 != HighlandsBiomes.desertMountains.biomeID &&
                		var9 != HighlandsBiomes.steppe.biomeID &&
                		var9 != HighlandsBiomes.glacier.biomeID &&
                		//islands
                		var9 != HighlandsBiomes.jungleIsland.biomeID &&
                		var9 != HighlandsBiomes.forestIsland.biomeID &&
                		var9 != HighlandsBiomes.desertIsland.biomeID &&
                		var9 != HighlandsBiomes.snowIsland.biomeID &&
                		var9 != HighlandsBiomes.volcanoIsland.biomeID &&
                		var9 != HighlandsBiomes.rockIsland.biomeID &&
                		var9 != HighlandsBiomes.windyIsland.biomeID
                		
                		&& !finished)
                {
                    var10 = var5[var8 + 1 + (var7 + 1 - 1) * (par3 + 2)];
                    var11 = var5[var8 + 1 + 1 + (var7 + 1) * (par3 + 2)];
                    var12 = var5[var8 + 1 - 1 + (var7 + 1) * (par3 + 2)];
                    var13 = var5[var8 + 1 + (var7 + 1 + 1) * (par3 + 2)];

                    if (!(var10 != HighlandsBiomes.ocean2.biomeID && var11 != HighlandsBiomes.ocean2.biomeID
                    		&& var12 != HighlandsBiomes.ocean2.biomeID && var13 != HighlandsBiomes.ocean2.biomeID))
                    {
                    	var6[var8 + var7 * par3] = BiomeGenBase.beach.biomeID;
                    	finished = true;
                    }
                }
                if (!(var9 != HighlandsBiomes.jungleIsland.biomeID &&
                		var9 != HighlandsBiomes.forestIsland.biomeID &&
                		var9 != HighlandsBiomes.desertIsland.biomeID &&
                		var9 != HighlandsBiomes.snowIsland.biomeID &&
                		var9 != HighlandsBiomes.volcanoIsland.biomeID &&
                		var9 != HighlandsBiomes.rockIsland.biomeID &&
                		var9 != HighlandsBiomes.windyIsland.biomeID)
                		
                		&& !finished)
                {
                    var10 = var5[var8 + 1 + (var7 + 1 - 1) * (par3 + 2)];
                    var11 = var5[var8 + 1 + 1 + (var7 + 1) * (par3 + 2)];
                    var12 = var5[var8 + 1 - 1 + (var7 + 1) * (par3 + 2)];
                    var13 = var5[var8 + 1 + (var7 + 1 + 1) * (par3 + 2)];
                    
                    

                    if (!((var10 == var9 || var10 == HighlandsBiomes.ocean2.biomeID)
                    		&& (var11 == var9 || var11 == HighlandsBiomes.ocean2.biomeID)
                    		&& (var12 == var9 || var11 == HighlandsBiomes.ocean2.biomeID)
                    		&& (var13 == var9 || var11 == HighlandsBiomes.ocean2.biomeID)
                    		))
                    {
                    	var6[var8 + var7 * par3] = HighlandsBiomes.ocean2.biomeID;
                    	finished = true;
                    }
                }
                //updated extreme hills borders
                if (var9 != BiomeGenBase.extremeHills.biomeID && !finished)
                {
                    var10 = var5[var8 + 1 + (var7 + 1 - 1) * (par3 + 2)];
                    var11 = var5[var8 + 1 + 1 + (var7 + 1) * (par3 + 2)];
                    var12 = var5[var8 + 1 - 1 + (var7 + 1) * (par3 + 2)];
                    var13 = var5[var8 + 1 + (var7 + 1 + 1) * (par3 + 2)];

                    if (!(var10 != BiomeGenBase.extremeHills.biomeID && var11 != BiomeGenBase.extremeHills.biomeID
                    		&& var12 != BiomeGenBase.extremeHills.biomeID && var13 != BiomeGenBase.extremeHills.biomeID))
                    {
                    	var6[var8 + var7 * par3] = BiomeGenBase.extremeHillsEdge.biomeID;
                    	finished = true;
                    }
                }
                // Highlands Bordered Biomes
                if (var9 != HighlandsBiomes.rockMountains.biomeID && !finished)
                {
                    var10 = var5[var8 + 1 + (var7 + 1 - 1) * (par3 + 2)];
                    var11 = var5[var8 + 1 + 1 + (var7 + 1) * (par3 + 2)];
                    var12 = var5[var8 + 1 - 1 + (var7 + 1) * (par3 + 2)];
                    var13 = var5[var8 + 1 + (var7 + 1 + 1) * (par3 + 2)];

                    if (!(var10 != HighlandsBiomes.rockMountains.biomeID && var11 != HighlandsBiomes.rockMountains.biomeID
                    		&& var12 != HighlandsBiomes.rockMountains.biomeID && var13 != HighlandsBiomes.rockMountains.biomeID))
                    {
                    	var6[var8 + var7 * par3] = BiomeGenBase.forestHills.biomeID;
                    	finished = true;
                    }
                }
                if (var9 != HighlandsBiomes.snowMountains.biomeID && !finished)
                {
                    var10 = var5[var8 + 1 + (var7 + 1 - 1) * (par3 + 2)];
                    var11 = var5[var8 + 1 + 1 + (var7 + 1) * (par3 + 2)];
                    var12 = var5[var8 + 1 - 1 + (var7 + 1) * (par3 + 2)];
                    var13 = var5[var8 + 1 + (var7 + 1 + 1) * (par3 + 2)];

                    if (!(var10 != HighlandsBiomes.snowMountains.biomeID && var11 != HighlandsBiomes.snowMountains.biomeID
                    		&& var12 != HighlandsBiomes.snowMountains.biomeID && var13 != HighlandsBiomes.snowMountains.biomeID))
                    {
                    	var6[var8 + var7 * par3] = BiomeGenBase.taigaHills.biomeID;
                    	finished = true;
                    }
                }
                if (var9 != HighlandsBiomes.desertMountains.biomeID && !finished)
                {
                    var10 = var5[var8 + 1 + (var7 + 1 - 1) * (par3 + 2)];
                    var11 = var5[var8 + 1 + 1 + (var7 + 1) * (par3 + 2)];
                    var12 = var5[var8 + 1 - 1 + (var7 + 1) * (par3 + 2)];
                    var13 = var5[var8 + 1 + (var7 + 1 + 1) * (par3 + 2)];

                    if (!(var10 != HighlandsBiomes.desertMountains.biomeID && var11 != HighlandsBiomes.desertMountains.biomeID
                    		&& var12 != HighlandsBiomes.desertMountains.biomeID && var13 != HighlandsBiomes.desertMountains.biomeID))
                    {
                    	var6[var8 + var7 * par3] = BiomeGenBase.desertHills.biomeID;
                    	finished = true;
                    }
                }
                if (var9 != HighlandsBiomes.tropicalIslands.biomeID && !finished)
                {
                    var10 = var5[var8 + 1 + (var7 + 1 - 1) * (par3 + 2)];
                    var11 = var5[var8 + 1 + 1 + (var7 + 1) * (par3 + 2)];
                    var12 = var5[var8 + 1 - 1 + (var7 + 1) * (par3 + 2)];
                    var13 = var5[var8 + 1 + (var7 + 1 + 1) * (par3 + 2)];

                    if (!(var10 != HighlandsBiomes.tropicalIslands.biomeID && var11 != HighlandsBiomes.tropicalIslands.biomeID
                    		&& var12 != HighlandsBiomes.tropicalIslands.biomeID && var13 != HighlandsBiomes.tropicalIslands.biomeID))
                    {
                    	var6[var8 + var7 * par3] = (HighlandsMain.improvedOceans ? HighlandsBiomes.ocean2.biomeID : BiomeGenBase.ocean.biomeID);
                    	finished = true;
                    }
                }
                if (var9 != HighlandsBiomes.flyingMountains.biomeID && !finished)
                {
                    var10 = var5[var8 + 1 + (var7 + 1 - 1) * (par3 + 2)];
                    var11 = var5[var8 + 1 + 1 + (var7 + 1) * (par3 + 2)];
                    var12 = var5[var8 + 1 - 1 + (var7 + 1) * (par3 + 2)];
                    var13 = var5[var8 + 1 + (var7 + 1 + 1) * (par3 + 2)];

                    if (!(var10 != HighlandsBiomes.flyingMountains.biomeID && var11 != HighlandsBiomes.flyingMountains.biomeID
                    		&& var12 != HighlandsBiomes.flyingMountains.biomeID && var13 != HighlandsBiomes.flyingMountains.biomeID))
                    {
                    	var6[var8 + var7 * par3] = (HighlandsMain.improvedOceans ? HighlandsBiomes.ocean2.biomeID : BiomeGenBase.ocean.biomeID);
                    	finished = true;
                    }
                }
                //any biome that is not a sub-biome is surrounded by Shrubland on its borders with any biome that is different from it in
                //temperature or rainfall levels by .3 or more, except with oceans or sub-biomes
                if(!finished && !isShoredOrSubBiome(var9)){
                	var10 = var5[var8 + 1 + (var7 + 1 - 1) * (par3 + 2)];
                    var11 = var5[var8 + 1 + 1 + (var7 + 1) * (par3 + 2)];
                    var12 = var5[var8 + 1 - 1 + (var7 + 1) * (par3 + 2)];
                    var13 = var5[var8 + 1 + (var7 + 1 + 1) * (par3 + 2)];
                    
                    float maxTempDifference = 0;
                    float maxRainDifference = 0;
                    
                    try{
                    	BiomeGenBase b0 = BiomeGenBase.biomeList[var9];
                    	BiomeGenBase b1 = BiomeGenBase.biomeList[var10];
                    	BiomeGenBase b2 = BiomeGenBase.biomeList[var11];
                    	BiomeGenBase b3 = BiomeGenBase.biomeList[var12];
                    	BiomeGenBase b4 = BiomeGenBase.biomeList[var13];
                    	
		                if(!(b0 instanceof BiomeGenBaseHighlands) ||
		                		(b0 instanceof BiomeGenBaseHighlands && !((BiomeGenBaseHighlands) b0).subBiomes.contains(b1))){
		                	maxTempDifference = Math.abs(b0.temperature - b1.temperature);
		                	maxRainDifference = Math.abs(b0.rainfall - b1.rainfall);
		                }
		                if(!(b0 instanceof BiomeGenBaseHighlands) ||
		                		(b0 instanceof BiomeGenBaseHighlands && !((BiomeGenBaseHighlands) b0).subBiomes.contains(b2))){
		                	maxTempDifference = Math.max(maxTempDifference, Math.abs(b0.temperature - b2.temperature));
		                	maxRainDifference = Math.max(maxRainDifference, Math.abs(b0.rainfall - b2.rainfall));
		                }
		                if(!(b0 instanceof BiomeGenBaseHighlands) ||
		                		(b0 instanceof BiomeGenBaseHighlands && !((BiomeGenBaseHighlands) b0).subBiomes.contains(b3))){
		                	maxTempDifference = Math.max(maxTempDifference, Math.abs(b0.temperature - b3.temperature));
		                	maxRainDifference = Math.max(maxRainDifference, Math.abs(b0.rainfall - b3.rainfall));
		                }
		                if(!(b0 instanceof BiomeGenBaseHighlands) ||
		                		(b0 instanceof BiomeGenBaseHighlands && !((BiomeGenBaseHighlands) b0).subBiomes.contains(b3))){
			                maxTempDifference = Math.max(maxTempDifference, Math.abs(b0.temperature - b4.temperature));
			                maxRainDifference = Math.max(maxRainDifference, Math.abs(b0.rainfall - b4.rainfall));
		                }
                    }
                    catch(Exception e){
                    	System.out.println("Error: Biome is null or has undefined temperature or rainfall.");
                    }
                    //System.out.println("deltaTemp = " + maxTempDifference + "   deltaRain = " + maxRainDifference);
                    
                    if (!((var10 == var9 || var10 == HighlandsBiomes.ocean2.biomeID || var10 == HighlandsBiomes.lake.biomeID || var10 == HighlandsBiomes.baldHill.biomeID)
                    		&& (var11 == var9 || var11 == HighlandsBiomes.ocean2.biomeID || var11 == HighlandsBiomes.lake.biomeID || var11 == HighlandsBiomes.baldHill.biomeID)
                    		&& (var12 == var9 || var12 == HighlandsBiomes.ocean2.biomeID || var12 == HighlandsBiomes.lake.biomeID || var12 == HighlandsBiomes.baldHill.biomeID)
                    		&& (var13 == var9 || var13 == HighlandsBiomes.ocean2.biomeID || var13 == HighlandsBiomes.lake.biomeID || var13 == HighlandsBiomes.baldHill.biomeID)
                    		)
                    		&& (maxTempDifference > 0.5 || maxRainDifference > 0.5))
                    {
                    	if(HighlandsMain.borderBiomeFlag && HighlandsBiomes.shrubland != null)
                    		var6[var8 + var7 * par3] = HighlandsBiomes.shrubland.biomeID;
                    	finished = true;
                    }
                }
            }
        }

        return var6;
    }
    
    private boolean isShoredOrSubBiome(int id){
    	for(int i : shoredBiomeList){
    		if(i == id)return true;
    	}
    	for(BiomeGenBase i : HighlandsBiomes.subBiomes){
    		if(i.biomeID == id)return true;
    	}
    	return false;
    }
}



