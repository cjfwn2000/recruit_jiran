package com.leecheolju.mydemo;

import org.springframework.data.repository.CrudRepository;

public interface MemoRepository extends CrudRepository<Memo, Integer> {
    
}
