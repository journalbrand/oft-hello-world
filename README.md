# OpenFastTrace - Simple Traceability Demo

This example demonstrates requirement tracing with OpenFastTrace (OFT) in a minimal Hello World application.

## Files

- `SimpleRequirement.md` - Contains two requirements for our Hello World program
- `SimpleHello.java` - Implementation that covers both requirements
- `SimpleHelloTest.java` - Unit tests that verify both requirements
- `.github/workflows/openfasttrace.yml` - GitHub Actions workflow to run OFT

## The Traceability Chain

This example demonstrates a complete traceability chain:

1. **Requirements** (`req`) - Define what the system should do
2. **Implementation** (`impl`) - Covers the requirements with code
3. **Unit Tests** (`utest`) - Verify the implementation meets the requirements

## Requirements

Our `SimpleRequirement.md` file defines two requirements:

```
`req~hello-output~1`
The program shall output "Hello, World!" when no name is provided.

`req~custom-greeting~1`
The program shall output "Hello, [name]!" when a name is provided.
```

Each requirement needs coverage from implementation (`impl`) and unit tests (`utest`).

## Implementation

The `SimpleHello.java` file implements both requirements and links back using tags:

```java
// [impl->req~hello-output~1]
// [impl->req~custom-greeting~1]
public static String greeting(String[] args) {
    if (args.length > 0 && args[0] != null && !args[0].trim().isEmpty()) {
        return "Hello, " + args[0] + "!";
    } else {
        return "Hello, World!";
    }
}
```

## Testing

The `SimpleHelloTest.java` file contains tests that verify both requirements:

```java
// [utest->req~hello-output~1]
public static void testDefaultGreeting() {
    String result = SimpleHello.greeting(new String[0]);
    assert "Hello, World!".equals(result);
}

// [utest->req~custom-greeting~1]
public static void testCustomGreeting() {
    String result = SimpleHello.greeting(new String[] {"Jane"});
    assert "Hello, Jane!".equals(result);
}
```

## Running the Trace

### Locally

When you run OpenFastTrace on these files locally:

```bash
java -jar openfasttrace.jar trace SimpleRequirement.md SimpleHello.java SimpleHelloTest.java
```

You'll see:

```
ok - 6 total
```

This shows that all requirements are fully covered both in implementation and tests.

### Via GitHub Actions

This repository includes a GitHub Actions workflow (`.github/workflows/openfasttrace.yml`) that automatically:

1. Sets up a Java environment
2. Downloads OpenFastTrace
3. Runs the trace to verify requirements are covered
4. Generates an HTML trace report
5. Saves the HTML report as a GitHub Actions artifact

The workflow runs on every push to the main branch, on pull requests, or can be triggered manually.

To view the HTML report:
1. Go to the Actions tab in your GitHub repository
2. Click on the latest workflow run
3. Scroll to the bottom and download the "oft-trace-report" artifact
4. Extract and open `trace-report.html` in your browser

## Understanding the Trace Results

### The 6 Specification Items

OFT finds 6 specification items in our example:

1. `req~hello-output~1` - Our first requirement (from SimpleRequirement.md)
2. `req~custom-greeting~1` - Our second requirement (from SimpleRequirement.md)
3. `impl~hello-output-XXXXXXXXXX~0` - Implementation coverage for first requirement (auto-generated ID)
4. `impl~custom-greeting-XXXXXXXXXX~0` - Implementation coverage for second requirement (auto-generated ID)
5. `utest~hello-output-XXXXXXXXXX~0` - Test coverage for first requirement (auto-generated ID)
6. `utest~custom-greeting-XXXXXXXXXX~0` - Test coverage for second requirement (auto-generated ID)

### What the Links Mean

The trace creates links between these specification items:

1. **Outgoing Links** - Where an item covers another item:
   - Implementation items cover → requirements
   - Test items cover → requirements

2. **Incoming Links** - Where an item is covered by another item:
   - Requirements are covered by ← implementation items
   - Requirements are covered by ← test items

3. **Coverage Status**:
   - "Covers" - An outgoing link is correctly established
   - "Covered shallow" - An incoming link is correctly established

### Complete Coverage

Our trace shows "ok - 6 total" because:

1. Both requirements explicitly state they need coverage from implementation and tests
2. Each requirement has both implementation and test coverage
3. All implementation and test items properly link back to their requirements
4. There are no orphaned items, duplicates, or missing coverage

This demonstrates successful requirements tracing where we can verify that all specified requirements are properly implemented and tested.

## Benefits of This Approach

1. **Complete Traceability** - Every requirement is traced to both code and tests
2. **Verification** - The testing ensures requirements are properly implemented
3. **Documentation** - The code itself documents which requirements it's implementing
4. **Quality Assurance** - Easily identify any missing coverage or broken links
5. **Continuous Integration** - Automatically verify requirement coverage with every code change 