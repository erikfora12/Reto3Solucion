package erik.main.service;

import erik.main.entity.bike;
import erik.main.repository.bikeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class bikeService {
    @Autowired
    bikeRepository bikeRp;

    public List<bike> getAll(){
        return bikeRp.getAll();
    }

    public bike save(bike c){
        if(c.getBikesId() == null){
            return bikeRp.save(c);
        }else{
            Optional<bike> Co = bikeRp.find(c.getBikesId());
            if (Co.isPresent()){
                return c;
            }else{
                return bikeRp.save(c);
            }
        }

    }

    public bike Update(bike c) {
        if (c.getBikesId() != null) {
            Optional<bike> Co = bikeRp.find(c.getBikesId());
            if(Co.isPresent()){
                bikeRp.save(Co.get());
                return Co.get();
            }else{ return c; }
        }else{ return c; }
    }

    public  boolean delete(int id){
        boolean flag =false;
        Optional <bike> c = bikeRp.find(id);

        if (c.isPresent()) {
            bikeRp.delete(id);
            flag =true;
        }

        return  flag;
    }
}