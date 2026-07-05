[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/KGJs7Wtk)
# POO-Java-SynchronizedMethods

Exemplo extraído do Oracle Java Tutorials para ilustrar métodos sincronizados (`synchronized`).
Fonte: https://docs.oracle.com/javase/tutorial/essential/concurrency/syncmeth.html

---

# Solução da Tarefa

Implementamos um contador thread-safe em **Java** (`SynchronizedCounter.java`) e uma versão equivalente em **Python** (`main.py`) usando exclusão mútua básica.

## Implementação em Java
A classe `SynchronizedCounter` define métodos sincronizados (`increment`, `decrement`, `value`) garantindo que as operações de escrita e leitura ocorram sob exclusão mútua, prevenindo condições de corrida:
```java
public synchronized void increment() {
    c++;
}
```

## Implementação em Python
No Python, alcançamos o mesmo comportamento através de um objeto do tipo `threading.Lock()` e o gerenciador de contexto `with`:
```python
def increment(self):
    with self._lock:
        self._c += 1
```

## Como Executar

### 1) Java
```bash
javac SynchronizedCounter.java
java SynchronizedCounter
```

### 2) Python
```bash
python main.py
```
