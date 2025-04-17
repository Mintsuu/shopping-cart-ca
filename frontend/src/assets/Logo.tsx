import { Text } from "@mantine/core";

function Logo({ size = 62 }: { size: number }) {
  return (
    <Text
      component="span"
      variant="gradient"
      gradient={{ from: "teal", to: "lime" }}
      fw={900}
      style={{ fontSize: `${size}px`, lineHeight: "1.1" }}
      inherit
    >
      GetFreshFood
    </Text>
  );
}

export default Logo;
