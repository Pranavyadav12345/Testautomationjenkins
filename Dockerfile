FROM ubuntu:22.04

# Install Java and Maven
RUN apt-get update && apt-get install -y \
    openjdk-17-jdk \
    maven \
 && rm -rf /var/lib/apt/lists/*

# Set working directory
WORKDIR /app

# Copy project files
COPY pom.xml .
COPY src ./src

# Run tests
CMD ["mvn", "clean", "test"]