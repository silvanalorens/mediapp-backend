package com.neuromotion.service;

import com.neuromotion.model.ResetToken;

public interface IResetTokenService {

    ResetToken findByToken(String token);

    void save(ResetToken token);

    void delete(ResetToken token);

}
