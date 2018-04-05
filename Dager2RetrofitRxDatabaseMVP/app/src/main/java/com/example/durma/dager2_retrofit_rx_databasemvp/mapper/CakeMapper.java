package com.example.durma.dager2_retrofit_rx_databasemvp.mapper;

import com.example.durma.dager2_retrofit_rx_databasemvp.mvp.model.Cake;
import com.example.durma.dager2_retrofit_rx_databasemvp.mvp.model.CakesResponse;
import com.example.durma.dager2_retrofit_rx_databasemvp.mvp.model.CakesResponseCakes;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by durma on 19.3.18..
 */

public class CakeMapper {
    @Inject
    public CakeMapper() {

    }

    public List<Cake> mapCakes(CakesResponse response){
        List<Cake> cakeList = new ArrayList<>();
        if (response != null) {
            List<CakesResponseCakes> responseCakes = response.getCakesResponseCakes();
            if (responseCakes != null) {
                for (CakesResponseCakes cake : responseCakes) {
                    Cake myCake = new Cake();
                    myCake.setId(cake.getId());
                    myCake.setDetailDescription(cake.getDetailDescription());
                    myCake.setImageURLl(cake.getImage());
                    myCake.setPreviewDescription(cake.getPreviewDescription());
                    myCake.setTitle(cake.getTitle());
                    cakeList.add(myCake);
                }
            }
        }

        return cakeList;
    }
}
