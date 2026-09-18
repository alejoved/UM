# Respuestas — Primer Parcial de Ingeniería de Requerimientos

1. **B.** La primera expresión es un objetivo de negocio y la segunda es un requisito de usuario.

2. **B.** `Cuenta` debe implementar los métodos `retirar(double valor)` y `consignar(double valor)` declarados por `CuentaOperacion`.

3. **D.** El sistema bancario es externo al sistema de inscripción y debe aparecer fuera de la caja del sistema.

4. **C.** Las condiciones que deben cumplirse antes de iniciar el caso de uso son precondiciones.

5. **C.** Expresa una necesidad de un estudiante y el valor que obtiene: conocer su avance académico.

6. **D.** El ciclo termina, pero el `println` está después de los `if`, así que el saldo se imprime una última vez.

7. **B.** Al implementar `CuentaOperacion`, `Cuenta` está obligada a definir sus métodos declarados.

8. **A.** El saldo final es `850`: se retiran `250` y luego se consignan `100`; los métodos públicos modifican el atributo privado de forma encapsulada.

9. **D.** El ciclo termina, pero el saldo se imprime una vez más durante esa misma iteración.

10. **C.** `CuentaOperacion` conserva las operaciones de cuenta y `TarjetaCredito` debe implementar `TarjetaCreditoOperacion` con su comportamiento propio.

11. **B.** Un atributo de instancia `double` recibe `0.0` por defecto en Java.

12. **C.** El saldo queda en `-50`, porque el método resta el valor sin validar si hay fondos suficientes.

13. **A.** Se asigna con `cuenta.setIdentificador("C-10")` y se consulta con `cuenta.getIdentificador()`.

14. **C.** `saldo` es privado, pero `getSaldo()` y `setSaldo(double)` permiten consultarlo y modificarlo mediante la interfaz pública de la clase.

15. **A.** `resta(22, 12)` devuelve `22 - 12`, es decir, `10.0`.

16. **D.** `Calculadora` realiza operaciones básicas de suma y resta sobre los valores recibidos.

17. **B.** `TarjetaCredito` tiene los atributos privados `identificador` y `cupo`, pero no implementa operaciones de pago.

18. **C.** La interfaz declara `pagar(double)` y `liberarCupo(double)`.

19. **C.** Antes de crear el objeto `Cuenta`, se solicita el identificador y luego el saldo.

20. **D.** No se ejecuta ninguna operación de cuenta, se imprime el saldo y el ciclo continúa porque la opción `4` no coincide con ninguno de los `if` ni con la condición de salida.
