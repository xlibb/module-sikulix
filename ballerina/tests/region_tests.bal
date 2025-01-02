import ballerina/test;

@test:Config 
function testRegion() {
    Region region = new(100, 100, 100, 100);
    test:assertEquals(region.getTopLeftX(), 100, msg = "Top left X coordinate mismatch");
    test:assertEquals(region.getTopLeftY(), 100, msg = "Top left Y coordinate mismatch");
    test:assertEquals(region.getBottomRightX(), 199, msg = "Bottom right X coordinate mismatch");
    test:assertEquals(region.getBottomRightY(), 199, msg = "Bottom right Y coordinate mismatch");
    test:assertEquals(region.getTopRightX(), 199, msg = "Top right X coordinate mismatch");
    test:assertEquals(region.getTopRightY(), 100, msg = "Top right Y coordinate mismatch");
    test:assertEquals(region.getCenterX(), 150, msg = "Center X coordinate mismatch");
    test:assertEquals(region.getCenterY(), 150, msg = "Center Y coordinate mismatch");
    test:assertEquals(region.getBottomLeftX(), 100, msg = "Bottom left X coordinate mismatch");
    test:assertEquals(region.getBottomLeftY(), 199, msg = "Bottom left Y coordinate mismatch");
    test:assertEquals(region.getH(), 100, msg = "Height mismatch");
    test:assertEquals(region.getW(), 100, msg = "Width mismatch");
}
