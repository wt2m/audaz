package audaz.services;

import audaz.repository.BaseRepository;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public abstract class BaseService<T, Y> implements BaseRepository<T, Y>{
    
    protected List<T> fakeDatabase;
    
    public BaseService(){
        fakeDatabase = new ArrayList<>();
    }
    
    public List<T> findAll(){
        
        
        List<T> models = this.fakeDatabase.stream()
                .filter(x -> x.getClass().isAssignableFrom(this.getType()))
                .collect(Collectors.toList());
        return models;
    }
    
    private Class<T> getType(){
        final ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<T>) (type).getActualTypeArguments()[0];
    }
}