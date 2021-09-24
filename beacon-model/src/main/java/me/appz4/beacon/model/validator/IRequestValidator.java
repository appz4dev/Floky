package me.appz4.beacon.model.validator;

import me.appz4.beacon.model.exception.ValidationException;

public abstract interface IRequestValidator
{
  public abstract boolean onValidate()
    throws ValidationException;
}


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\validator\IRequestValidator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */