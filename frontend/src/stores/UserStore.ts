import { create } from "zustand";

export type User = {
  id: number;
  email: string;
  firstName: string;
  lastName: string;
  role: "customer" | "staff" | "";
};

interface UserState {
  user: User;
  setUserState: (user: User, isAuth: boolean) => void;
  removeUserState: () => void;
  isAuthenticated: boolean;
}

export const useUserStore = create<UserState>()((set) => ({
  user: {
    firstName: "",
    lastName: "",
    id: 0,
    email: "",
    role: "",
  },
  isAuthenticated: false,
  setUserState: (user: User, isAuth: boolean) =>
    set(() => ({ user: user, isAuthenticated: isAuth })),
  removeUserState: () =>
    set(() => ({
      user: {
        email: "",
        firstName: "",
        id: 0,
        lastName: "",
        role: "",
      },
      isAuthenticated: false,
    })),
}));

export const useUser = () => useUserStore((state) => state.user);
export const useIsAuth = () => useUserStore((state) => state.isAuthenticated);
