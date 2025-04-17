import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import { MantineProvider } from "@mantine/core";
import { BrowserRouter, Route, Routes } from "react-router";
import { adminRoutes, mainRoutes, shopRoutes } from "@/routes/Routes.tsx";
import "./index.css";
import "@mantine/core/styles.css";
import "mantine-datatable/styles.layer.css";
import "@mantine/dates/styles.css";
import "@mantine/code-highlight/styles.css";

createRoot(document.getElementById("root")!).render(
  <StrictMode>
    <BrowserRouter>
      <MantineProvider>
        <Routes>
          {[...adminRoutes, ...mainRoutes, ...shopRoutes].map((route) => {
            if (route.children)
              return (
                <Route path={route.path} element={route.element}>
                  {route.children.map((childRoute) => (
                    <Route
                      index={childRoute.defaultPage}
                      path={childRoute.path}
                      element={childRoute.element}
                    />
                  ))}
                </Route>
              );
            else return <Route path={route.path} element={route.element} />;
          })}
        </Routes>
      </MantineProvider>
    </BrowserRouter>
  </StrictMode>
);
