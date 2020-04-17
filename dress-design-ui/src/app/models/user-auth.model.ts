export interface AuthToken {
  token: string;
}

export class LoginCredentials {
  username: string;
  password: string;
}

export class UserRegistration {
  fullName: string;
  loginId: string;
  password: string;
  phone: string;
  email?: string;
  gender: string;
}
