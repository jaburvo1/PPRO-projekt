package repozitory;

import com.example.pproprojekt.entity.Depot;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class DepotRepozitoryOracel implements DepotRepozitory{
    @Override
    public List<Depot> findAll() {
        return null;
    }

    @Override
    public List<Depot> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Depot> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Depot> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Depot entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Depot> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Depot> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Depot> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Depot> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Depot> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Depot> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Depot> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Depot getOne(Long aLong) {
        return null;
    }

    @Override
    public Depot getById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Depot> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Depot> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Depot> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Depot> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Depot> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Depot> boolean exists(Example<S> example) {
        return false;
    }
}
