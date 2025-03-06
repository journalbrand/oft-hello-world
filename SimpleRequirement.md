# Simple Hello World Requirements

## Basic Output
`req~hello-output~1`

The program shall output "Hello, World!" when no name is provided.

Rationale:
This is the traditional behavior of a Hello World program.

Needs: impl, utest

Covers:
- req~components-have-requirements~1

## Customizable Greeting
`req~custom-greeting~1`

The program shall output "Hello, [name]!" when a name is provided.

Rationale:
This demonstrates parameter handling in a simple way.

Needs: impl, utest

Covers:
- req~components-have-requirements~1 