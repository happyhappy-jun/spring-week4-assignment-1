package com.codesoom.assignment.application.interfaces;

import com.codesoom.assignment.domain.Toy;

/**
 * Product 타입 생성에 대한 비지니스 로직
 * <p>
 * All Known Implementing Classes:
 * ToyCreateService
 * </p>
 */
public interface ProductCreateService {
    /**
     * Toy 엔티티 객체 생성
     * <p>
     * @param toy Toy 객체
     * @return Toy 객체
     * </p>
     */
    Toy create(Toy toy);
}
