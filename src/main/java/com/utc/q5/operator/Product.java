package com.utc.q5.operator;

import com.utc.q5.Expression;

public class Product implements Expression {
  
  private final Expression leftExpression;
  private final Expression rightExpression;
  
  public Product(Expression leftExpression, Expression rightExpression) {
    this.leftExpression = leftExpression;
    this.rightExpression = rightExpression;
  }
  
  @Override
  public int interpret() {
    return leftExpression.interpret() * rightExpression.interpret();
  }
}

