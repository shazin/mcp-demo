MCP Spring Client Server Demo
=============================

Steps to run the demo
---------------------

1. Build application with `mvn clean package`
2. Run the client application with `java -DSPRING_OPENAI_API_KEY=your_openai_api_key_here -jar ./mcp-client-demo/target/mcp-client-demo-0.0.1-SNAPSHOT.jar`

   Replace `your_openai_api_key_here` with your actual OpenAI API key. This key is required for the client to interact with the OpenAI API.
3. Open your browser and navigate to `http://localhost:8090` to see the demo in action.