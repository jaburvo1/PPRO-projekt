package repozitory;

import com.example.pproprojekt.entity.Complaint;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class ComplaintRepositoryOracle implements ComplaintRepository{
    @Override
    public List<Complaint> findAll() {
        return null;
    }

    @Override
    public List<Complaint> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Complaint> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Complaint> findAllById(Iterable<Long> longs) {
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
    public void delete(Complaint entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Complaint> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Complaint> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Complaint> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Complaint> findById(Long aLong) {
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
    public <S extends Complaint> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Complaint> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Complaint> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Complaint getOne(Long aLong) {
        return null;
    }

    @Override
    public Complaint getById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Complaint> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Complaint> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Complaint> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Complaint> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Complaint> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Complaint> boolean exists(Example<S> example) {
        return false;
    }
}
