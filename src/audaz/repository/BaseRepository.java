package audaz.repository;

import java.util.List;

public interface BaseRepository<T, Y> {
   public abstract T insert(T entity) throws Exception;
   public abstract List<T> list()throws Exception;
   public abstract T delete(T entity) throws Exception;
   public abstract T update(T entity) throws Exception;
}
