# Bit Manipulations

- Leading zeros `0` (i.e., to the left) are meaningless

## `~` NOT

- Invert a bit
- Examples:
    - `~0 = 1`
    - `~1 = 0`
    - `~0111 = 1000`
    - `~100 = 011`
- In Java, `~` inverts an `int` and not single bits, so:

```java
int b = 0b10;
~b == 11111111111111111111111111111101
```

## `&` AND

- When we AND two bit we get a `1` only if **both** the bits are one.
- AND can be used to find if a certain bit in a number contains `1` or `0`.
- Can be considered like multiplying all bits.
- Examples:
    - `10 & 11 = 10`
    - `0011 & 0010 = 0010`

## `|` OR

- When we OR we get `1` if **either** of the two bits are one.
- OR can be used to set a specific bit to `1`.
- Examples:
    - `10 | 11 = 11`
    - `0011 | 0010 = 0011`

## `^` XOR

- When we do XOR we need **exactly** one of the two bits to be a `1`. If both are `1` we get a `0`.
- Enables to compare two bits – `1` means they are different, `0` means they are the same.
- Can be used to invert selected bits in a register. Any bit can be toggled by XOR-ing it with `1`.
- XOR-ing a value against itself yields zero.
- Examples:
    - `0101 ^ 0011 = 0110`
    - `0010 ^ 1010 = 1000`
    - `0101` to toggle the first `1` bit we XOR it with `0001` `=> 0100`   
- XOR can be used for "backup":
    - Calculate `a` and `b`'s XOR: `x = a^b`
    - If needed, recover `a`: `a = b^x`
    - If needed, recover `b`: `b = a^x`

## `<<` Signed Left Shift

- `i << n` means adding `n` number of `0` bits to the right of `i`.
- The signed left shift operator "<<" shifts a bit pattern to the left. The bit pattern is given by the left-hand operand, and the number of positions to shift by the right-hand operand
- A left arithmetic shift by `n` is equivalent to multiplying the number by `2^n`.
- For example: `10111 << 1 = 101110` (left shifting 23 by 1 results in 46).

## `>>` Signed Right Shift
- `i >> n` means removing `n` bits from the right (`0` or `1`).
- The left most bit depends on the sign extension. Left most bit will be the original sign bit instead of a `0`.
- A right arithmetic shift by `n` is equivalent to dividing by `2^n`.
- For example: `11101001 >> 1 = 11110100` (right signed shifting -23 by 1 results in -12)


## `>>>` Unsigned Right Shift
- `i >>> n` is same as Right shift except shifts a `0` into the left most position.

## Binary Numbers

```
0 = 0
1 = 1
10 = 2
11 = 3
100 = 4
101 = 5
110 = 6
111 = 7
1000 = 8
1001 = 9
1010 = 10
1011 = 11
1100 = 12
1101 = 13
1110 = 14
1111 = 15
10000 = 16
...
```

```
10010110
^      ^
|      |------- bit 0
|
|-------------- bit 7
```

Having a `1` in the `k`-th bit, means that the decimal number is comprised of `2^k`. For example, for the above number:

```
2^7 + 2^4 + 2^2 + 2^1 = 150
```