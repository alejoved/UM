
# Respuestas — Primer Parcial de Arquitectura de Software

1. **B.** `CuentaBancaria` debe implementar los métodos `retirar` y `consignar` definidos por `CuentaOperacion`.

2. **D.** El impuesto es `200000 * 19 / 100 = 38000`; por tanto, el total es `238000`.

3. **D.** Con la opción `3` no se ejecuta ningún bloque `if`, pero sí se imprime el saldo antes de que termine el ciclo.

4. **D.** Procesar 100.000 transacciones por segundo es un requisito de rendimiento arquitectónicamente significativo.

5. **A.** Es una restricción regulatoria que limita las alternativas de despliegue y ubicación de los datos.

6. **B.** Se evidencia polimorfismo mediante referencias de tipo interfaz y objetos concretos.

7. **B.** El método retorna `550000`, pero no modifica `saldo`; el saldo interno permanece en `1000000`.

8. **B.** El método recibe la abstracción `MedioPago` y puede trabajar con diferentes implementaciones mediante polimorfismo.

9. **C.** Crear `PagoCripto implements MedioPago` extiende el sistema sin modificar `Ejecucion` ni las implementaciones existentes.

10. **A.** `Factura` representa los datos y `FacturaOperacion` concentra las operaciones, con motivos de cambio más acotados.

11. **A.** La clase reúne responsabilidades relacionadas con el concepto de cuenta bancaria y su comportamiento básico.

12. **B.** Agregar una implementación nueva sin modificar las existentes aplica el principio Open/Closed.

13. **A.** Una referencia `Cuenta` debe poder utilizar cualquiera de sus subclases sin romper el comportamiento esperado.

14. **A.** `MedioPago` define un contrato pequeño y específico para realizar cobros.

15. **A.** Es Interface Segregation: cada cliente depende solo de la operación de notificación que necesita.

16. **A.** Recibir `MedioPago` hace que `Ejecucion` dependa de una abstracción y no de una clase concreta.

17. **A.** El cambio debe realizarse en `FacturaOperacion`, que concentra el cálculo, sin alterar la clase de datos `Factura`.

18. **A.** Se puede crear una interfaz y una implementación específicas para WhatsApp sin agregar métodos innecesarios a las existentes.

19. **A.** El cliente trabaja contra el contrato `CuentaOperacion` y puede sustituir la implementación por otra compatible.

20. **A.** `MedioPago` abstrae el cobro, `Ejecucion` depende de la abstracción y cada pago concreto implementa su propio comportamiento.
